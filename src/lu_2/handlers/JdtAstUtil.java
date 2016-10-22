package lu_2.handlers;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class JdtAstUtil {
	@SuppressWarnings("deprecation")
	private ASTParser astParser=ASTParser.newParser(AST.JLS3);
	

	public CompilationUnit getCompilationUnit(ICompilationUnit unit) {
		// TODO Auto-generated method stub
		astParser.setSource(unit);
		astParser.setKind(ASTParser.K_COMPILATION_UNIT);
		CompilationUnit result=(CompilationUnit) astParser.createAST(null);
		return result;
	}
}
