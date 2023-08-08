package io.hostilerobot.yapping.token;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.psi.tree.IElementType;
import io.hostilerobot.yapping.intellijplugin.language.YappingLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public final class YappingElementType extends IElementType {

    public YappingElementType(@NonNls @NotNull String debugName) {
        super(debugName, YappingLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "YappingTokenType." + super.toString();
    }
}