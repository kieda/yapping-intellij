package io.hostilerobot.yapping.intellijplugin.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionInitializationContext;
import org.jetbrains.annotations.NotNull;

public class YappingCompletionContributor extends CompletionContributor {
    public YappingCompletionContributor() {

    }
    public static final String DUMMY_IDENTIFIER = "___xxxYappingDummy___zzz";
    @Override
    public void beforeCompletion(@NotNull CompletionInitializationContext context) {
        context.setDummyIdentifier(DUMMY_IDENTIFIER);
    }
}
