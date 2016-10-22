package lu_2.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.omg.CORBA.PRIVATE_MEMBER;

public class Test extends AbstractHandler{
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		System.out.println("Plug_in activited");
		
		IWorkspace workspace=ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root=workspace.getRoot();
		IProject[] projects=root.getProjects();
		
		for(IProject project:projects){
			try {
				if (project.isOpen()&&project.isNatureEnabled("org.eclipse.jdt.core.javanature")) {	
					IJavaProject javaProject=JavaCore.create(project);
					IPackageFragment[] ipackages=javaProject.getPackageFragments();
					for(IPackageFragment ipackage:ipackages){
						if (ipackage.getKind()==IPackageFragmentRoot.K_SOURCE) {
							for(ICompilationUnit unit:ipackage.getCompilationUnits()){
								CompilationUnit cUnit=new JdtAstUtil().getCompilationUnit(unit);
								VisitorDemo demo=new VisitorDemo();
								cUnit.accept(demo);
							}
						}
					}
				}
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
