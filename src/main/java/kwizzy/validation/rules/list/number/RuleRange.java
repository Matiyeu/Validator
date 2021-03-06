package kwizzy.validation.rules.list.number;

import kwizzy.validation.impl.Form;
import kwizzy.validation.rules.list.AbstractRule;
import kwizzy.validation.rules.DefaultRules;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Optional;

/**
 * Ref to {@link DefaultRules#RANGE}<br/>
 * Usage: addRule("field -> range:int min, int max") <br/>
 * Example:
 * <pre>
 * "123"  12,124  -> true
 * "42"   45,46   -> false
 * </pre>
 **/
public class RuleRange extends AbstractRule {

    @Override
    public boolean isOkay(Form f) {
        Optional<String> s = f.getString(rule.getField());
        String p1 = getRuleInfo().getParams().get(0);
        String p2 = getRuleInfo().getParams().get(1);
        if (s.isPresent() && NumberUtils.isParsable(s.get())) {
            System.out.println(String.format("%s <= %s && %s >= %s", s.get(), p2, s.get(), p1));
            JexlEngine jexl = new JexlBuilder().create();
            String jexlExp = String.format("%s <= %s && %s >= %s", s.get(), p2, s.get(), p1);
            JexlExpression e = jexl.createExpression(jexlExp);
            return (boolean)e.evaluate(new MapContext());
        }
        return false;
    }
}