package io.github.sskorol.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.github.sskorol.core.BaseConfig.BASE_CONFIG;

/**
 * A utility class for different mapping the regexp value to origin value.
 */
@SuppressWarnings({"HideUtilityClassConstructor", "PMD.UseUtilityClass"})
@UtilityClass
public final class RegexpUtils {

    public static WebElement getMappedElement(final List<WebElement> webElements,
                                              final String regexp,
                                              final String accessCodeHtml,
                                              final String value) {

        final Map<String, WebElement> hashMap = new LinkedHashMap<>();

        for (int i = 0; i < webElements.size(); i++) {
            hashMap.put(getValuesByGroup(regexp, accessCodeHtml, BASE_CONFIG.regexpGroup()).get(i), webElements.get(i));
        }

        return hashMap.get(value);
    }

    public static List<String> getValuesByGroup(final String regexp,
                                                final String condition,
                                                final int group) {

        final List<String> arrayList = new ArrayList<>();

        final Pattern p = Pattern.compile(regexp);
        final Matcher m = p.matcher(condition);

        while (m.find()) {
            arrayList.add(m.group(group));
        }
        return arrayList;
    }
}
