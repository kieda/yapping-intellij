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
 * .yas filetype. Used to describe script functionality in the yapping format.
 */
public class YasFileType extends LanguageFileType {
    public static final YasFileType INSTANCE = new YasFileType();

    private YasFileType() {
        super(YappingLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Yap Script";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Script for yap files";
    }

    @Override
    public @Nls @NotNull String getDisplayName() {
        return getName();
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "yas";
    }

    @Override
    public Icon getIcon() {
        return null;
    }
}
