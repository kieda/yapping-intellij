package io.hostilerobot.yapping.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import org.jetbrains.annotations.NotNull;

public class YappingLexerAdapter extends FlexAdapter {
    public YappingLexerAdapter() {
        super(new YappingLexer(null));
    }
}
