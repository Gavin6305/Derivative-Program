import java.util.ArrayList;
/**
 * The representation of a mathematical expression
 * expr := [+ | -] term {(+ | -) term}
 *
 * @author Gavin Pinto
 * @version 11/01/2024
 */
public class Expression {
    private Term[] terms;
    /**
     * Constructs an Expression object 
     * 
     * @param terms the Array of Term objects that represent the mathematical expression
     */
    public Expression (Term[] terms) {
        this.terms = terms;
    }

    /**
     * Constructs an Expression object 
     * 
     * @param expression the mathematical expression as a String
     */
    public Expression (String expression) {
        ArrayList<Term> result = new ArrayList<>();
        StringBuilder currentTerm = new StringBuilder();
        int parenthesesLevel = 0;
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == ' ') {
                continue;
            }
            switch (symbol) {
                case '+':
                if (parenthesesLevel == 0) {
                    result.add(new Term(currentTerm.toString()));
                    currentTerm.setLength(0);
                }
                else {
                    currentTerm.append(symbol);
                }
                break;
                case '-':
                if (parenthesesLevel == 0) {
                    result.add(new Term(currentTerm.toString()));
                    currentTerm.setLength(0);
                }
                currentTerm.append(symbol + "1*");
                break;
                case '(':
                parenthesesLevel++;
                currentTerm.append(symbol);
                break;
                case ')':
                parenthesesLevel--;
                currentTerm.append(symbol);
                break;
                default:
                currentTerm.append(symbol);
            }
        }
        result.add(new Term(currentTerm.toString()));
        this.terms = result.toArray(new Term[0]); 
    }

    /**
     * Computes the derivative of the Expression
     * 
     * @return An Expression representing the derivative
     */
    public Expression derivative () {
        Expression derivatives = new Expression(new Term[this.terms.length]);
        for (int i = 0; i < this.terms.length; i++) {
            derivatives.terms[i] = this.terms[i].derivative();
        }
        return derivatives;
    }

    /**
     * @return The String representation of an Expression 
     */
    @Override
    public String toString () {
        StringBuilder result = new StringBuilder();
        for (Term term : this.terms) {
            result.append(term.toString());
        }
        return result.toString();
    }
}