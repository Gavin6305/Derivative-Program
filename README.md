# Derivative-Program
This is a Java project that will compute the derivative of any mathematical function.

Below is the grammar used to parse the entered expression. 

expr := [+ | -] term {(+ | -) term}
    term := division | multiplication | function
        division := dividend / divisor
            dividend := function
            divisor := function
        multiplication := multiplicand * multiplier
            multiplicand := function
            multiplier := term
        function := exponentialFunction | trigFunction | logFunction | sqrtFunction | firstEvaluated
            exponentialFunction := expBase ^ exponent
                expBase := trigFunction | logFunction | sqrtFunction | firstEvaluated
                exponent := function
            trigFunction := (SIN | COS | TAN | CSC | SEC | COT) ( expr )
            logFunction := (LOG [ logBase ] | LN) ( expr )
                logBase := expr
            sqrtFunction := SQRT ( expr )
            firstEvaluated := parentheses | constant | VARIABLE
                parentheses := ( expr )
                constant := ECONST | PICONST | CONSTANT
                
Each symbol represents an operation, function, or syntax that follow conventional mathematical rules.
This was made to safely handle derivative calculation for certain situations such as the product rule, quotient rule, power rule, etc.
Each non-terminal symbol (lowercase words) has an associated class and attributes representing its derivation.