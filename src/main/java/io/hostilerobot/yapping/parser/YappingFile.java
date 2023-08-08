package io.hostilerobot.yapping.parser;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import io.hostilerobot.yapping.intellijplugin.filetypes.YapFileType;
import io.hostilerobot.yapping.intellijplugin.language.YappingLanguage;
import org.jetbrains.annotations.NotNull;

public class YappingFile extends PsiFileBase {

    protected YappingFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, YappingLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return YapFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Yap File";
    }
}
