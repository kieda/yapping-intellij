package io.hostilerobot.yapping.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import io.hostilerobot.yapping.intellijplugin.language.YappingLanguage;
import io.hostilerobot.yapping.lexer.YappingLexerAdapter;
import io.hostilerobot.yapping.token.YappingTokenSets;
import org.jetbrains.annotations.NotNull;

public class YappingParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(YappingLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new YappingLexerAdapter();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new YappingParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return YappingTokenSets.COMMENTS;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return YappingTokenSets.LITERALS;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return YappingTypes.Factory.createElement(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new YappingFile(viewProvider);
    }
}
