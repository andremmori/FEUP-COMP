/* Generated By:JJTree: Do not edit this line. ASTarray.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTarray extends SimpleNode {
  public ASTarray(int id) {
    super(id);
  }

  public ASTarray(JmmParser p, int id) {
    super(p, id);
  }

  public void applySemanticAnalysis(Table table) throws Exception {
    SimpleNode var = ((SimpleNode) children[0]);
    SimpleNode access = ((SimpleNode) children[1]);
    if(table == null) return;
    if(access.name == null && access.getName().equals("true")){
        throw new Exception("Index not valid.");
    }

    if (var.name != null) {
      Symbol s = table.getSymbol(var.name);
      if (s != null) {
        if (!s.getType().equals("int[]")) {
          throw new RuntimeException("Variable not of type int[] on line " + line);
        }

        if (!s.isInitialized()) {
          throw new RuntimeException("Array not initialized on line " + line);
        }

        access.applySemanticAnalysis(table);
        return;
      }

      throw new RuntimeException(var.name + " isn't a known variable on line " + line);
    }
  }
}
/* JavaCC - OriginalChecksum=e75ce836e5526852ed8ea209a0591c30 (do not edit this line) */
