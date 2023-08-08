package io.hostilerobot.yapping.token;

import com.intellij.psi.tree.TokenSet;
import io.hostilerobot.yapping.parser.YappingTypes;

public interface YappingTokenSets {
    TokenSet LITERALS = TokenSet.create(YappingTypes.LITERAL);
    TokenSet IDENTIFIERS = TokenSet.create(YappingTypes.REGEX, YappingTypes.FNAME);
    TokenSet COMMENTS = TokenSet.create(YappingTypes.COMMENT);
}
