package io.hostilerobot.yapping.intellijplugin.language;

import com.intellij.lang.Language;

public class YappingLanguage extends Language {
    public static final YappingLanguage INSTANCE = new YappingLanguage();
    private YappingLanguage() {
        super("Yapping");
    }
}
