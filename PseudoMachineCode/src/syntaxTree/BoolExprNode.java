/**
 * 
 */
package syntaxTree;

/**
 * @author Tarek
 * 
 */
public class BoolExprNode extends BooleanExpressionNode {
	ArithmeticExpressionNode op1, op2;
	char operator;
	

	/**
	 * @param location location of the expression in the source
	 */
	protected BoolExprNode(SourceLocator location) {
		super(location);
	}

	/**
	 * 
	 * @param location location of the expression in the source file
	 * @param expression is the first operand
	 * @param expression is the second operand
	 * @param operator is the comparing operator
	 */
	public BoolExprNode(SourceLocator location,
			ArithmeticExpressionNode op1, ArithmeticExpressionNode op2, char operator ) {
		super(location);
		this.op1=op1;
		this.op2=op2;
		this.operator = operator;
	}

	@Override
	public boolean evaluateBoolean() throws Exception {
		switch (operator) {
		case '=': if(op1.evaluate() == op2.evaluate()){
               return true;
               } else {
            	   return false;
            	   }
		case '<':  if(op1.evaluate() < op2.evaluate()){
            return true;
            } else {
         	   return false;
         	   }
		case '>':  if(op1.evaluate() > op2.evaluate()){
            return true;
            } else {
         	   return false;
         	   }
		case 'l':  if(op1.evaluate() <= op2.evaluate()){
            return true;
            } else {
         	   return false;
         	   }
		case 'g':  if(op1.evaluate() >= op2.evaluate()){
            return true;
            } else {
         	   return false;
         	   }
		default: throw new Exception("unknown operator");
		}
	}
}
