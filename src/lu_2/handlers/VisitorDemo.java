package lu_2.handlers;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class VisitorDemo extends ASTVisitor{
	private boolean entityExist=false;
	@Override
	public boolean visit(TypeDeclaration node) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean visit(MethodDeclaration node) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean visit(FieldDeclaration node) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean visit(MarkerAnnotation node) {
		// TODO Auto-generated method stub
		if (node.getTypeName().toString().equals("Entity")) {
			entityExist=true;
			System.out.println("Entity Found");
			return false;
		}
		return true;
	}
	
}
