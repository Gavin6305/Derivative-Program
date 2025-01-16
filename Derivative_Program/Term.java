/**
 * The representation of a term in mathematics.                                      
 * Each term can only be a division, multiplication, or function.                    
 * 
 * term := division | multiplication | function
 *
 * @author Gavin Pinto
 * @version 11/01/2024
 */
public class Term {
    private Division division; 
    private Multiplication multiplication;
    private Function function;
    
    public Term (String term) {
        this.function = new Function(term);
        this.multiplication = null;
        this.division = null;
        int parenthesesLevel = 0;
        for (int i = 0; i < term.length(); i++) {
            char symbol = term.charAt(i);
            switch (symbol) {
                case '*':
                if (parenthesesLevel == 0) {
                    String left = term.substring(0, i);
                    String right = term.substring(i + 1, term.length());
                    this.multiplication = new Multiplication(left, right);
                    this.division = null;
                    this.function = null;
                    return;
                }
                break;
                case '/':
                if (parenthesesLevel == 0) {
                    String left = term.substring(0, i);
                    String right = term.substring(i + 1, term.length());
                    this.division = new Division(left, right);
                    this.multiplication = null;
                    this.function = null;
                    return;
                }
                break;
                case '(':
                parenthesesLevel++;
                break;
                case ')':
                parenthesesLevel--;
                break;
                default:
                break;
            }
        }
    }

    public Term derivative () {
        return null;
    }
}
