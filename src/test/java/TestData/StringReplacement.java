package TestData;



import TestContext.TestContext;
import org.codehaus.plexus.interpolation.fixed.FixedStringSearchInterpolator;
import org.codehaus.plexus.interpolation.fixed.FixedValueSource;
import org.codehaus.plexus.interpolation.fixed.MapBasedValueSource;

import java.util.HashMap;

public class StringReplacement {
    HashMap<String, String> context = new HashMap<>();
    public StringReplacement() {
    }



    public static String formatString(String stringValue,  TestContext context) {
        return context != null ? FixedStringSearchInterpolator.create(new FixedValueSource[]{new MapBasedValueSource(context)}).interpolate(stringValue): "Darek";

    }
}
