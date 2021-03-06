package kwizzy.validation.rules.list.str;

import kwizzy.validation.impl.Form;
import kwizzy.validation.rules.list.AbstractRule;
import kwizzy.validation.rules.DefaultRules;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * Ref to {@link DefaultRules#ALPHA}<br/>
 * Usage: addRule("field -> alpha") <br/>
 * Example:
 * <pre>
 * ""        -> false
 * " "       -> false
 * "     "   -> false
 * "    b "  -> true
 * </pre>
 **/
public class RuleAlpha extends AbstractRule {

    @Override
    public boolean isOkay(Form f) {
        Optional<String> s = f.getString(rule.getField());
        return s.filter(StringUtils::isAlpha).isPresent();
    }
}
