/* Generated By:JJTree: Do not edit this line. ASTmethodDeclaration.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTmethodDeclaration extends SimpleNode {
  public ASTmethodDeclaration(int id) {
    super(id);
  }

  public ASTmethodDeclaration(JmmParser p, int id) {
    super(p, id);
  }

  public void createTable(Table table) {
    ASTtype typeNode = (ASTtype) children[0];
    Table methodTable = new Table(table, typeNode.getType());

    String methodName = ((SimpleNode) children[1]).name + "(";

    for (int i = 0; i < children.length; i++) {
      if (children[i] instanceof ASTparameterDeclaration) {
        methodName += ((ASTparameterDeclaration) children[i]).getType();
        if(i < children.length-3){
            methodName += ",";
        }
      }
    }

    methodName += ")";
    JmmParser.getInstance().addMethod(methodName, methodTable);

    for (int i = 0; i < children.length; i++) {
      ((SimpleNode) children[i]).createTable(methodTable);
    }
  }

  public void applySemanticAnalysis(Table table) throws Exception {
    String methodName = ((SimpleNode) children[1]).name + "(";

    for (int i = 0; i < children.length; i++) {
      if (children[i] instanceof ASTparameterDeclaration) {
        methodName += ((ASTparameterDeclaration) children[i]).getType();
      }
    }

    methodName += ")";

    Table methodTable = JmmParser.getInstance().getMethods().get(methodName);

    if (children == null)
      return;

    for (int i = 0; i < children.length; i++) {
      ((SimpleNode) children[i]).applySemanticAnalysis(methodTable);
    }
  }
}
/* JavaCC - OriginalChecksum=a9e5f2a371282d1de89860cb1df4fb52 (do not edit this line) */
