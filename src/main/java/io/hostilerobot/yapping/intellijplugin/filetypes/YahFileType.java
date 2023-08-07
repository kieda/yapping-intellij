package io.hostilerobot.yapping.intellijplugin.filetypes;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import io.hostilerobot.yapping.intellijplugin.language.YappingLanguage;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * .yah filetype. Used to describe imports using yapping language
 */
public class YahFileType extends LanguageFileType {
    public static final YahFileType INSTANCE = new YahFileType();

    private YahFileType() {
        super(YappingLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Yap Header";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Header for yap files";
    }

    @Override
    public @Nls @NotNull String getDisplayName() {
        return getName();
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "yah";
    }

    @Override
    public Icon getIcon() {
        return null;
    }
}
