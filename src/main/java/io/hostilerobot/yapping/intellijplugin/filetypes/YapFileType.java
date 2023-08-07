package io.hostilerobot.yapping.intellijplugin.filetypes;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import io.hostilerobot.yapping.intellijplugin.language.YappingLanguage;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * .yap filetype. Used to describe data, scripts, etc in the yapping language
 */
public class YapFileType extends LanguageFileType {
    public static final YapFileType INSTANCE = new YapFileType();

    private YapFileType() {
        super(YappingLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Yap File";
    }

    @Override
    public @Nls @NotNull String getDisplayName() {
        return getName();
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "General-use files in the yapping language";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "yap";
    }

    @Override
    public Icon getIcon() {
        //"/icons/jar-gray.png"
        try {
            return IconLoader.findIcon(new URL("file:///Users/zkieda/Dropbox/Projects/yapping-intellij/src/main/resources/META-INF/pluginIcon.svg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
