package io.hostilerobot.yapping.parser.grammar;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Predicate;

// creates an iterator for a psielement, ignoring items where isElement evaluates to false
public class PsiListIterable implements Iterable<PsiElement> {
    private final PsiElement head;
    private final Predicate<PsiElement> isElement;
    private final Predicate<PsiElement> isRecursive;

    public PsiListIterable(PsiElement head, Predicate<PsiElement> isElement) {
        this(head, isElement, elem -> false);
    }

    public PsiListIterable(PsiElement head,
                           Predicate<PsiElement> isElement,
                           Predicate<PsiElement> isRecursive) {
        this.head = head;
        this.isElement = isElement;
        this.isRecursive = isRecursive;
    }

    // O(1) space recursive tree iterator!!!
    private class PsiListIterator implements Iterator<PsiElement> {
        private PsiElement node;
        private PsiElement previous;
        private boolean visitedHead;
        public PsiListIterator() {
            previous = null;
            visitedHead = false;
            node = head;
            findNextChild();
        }
        private void findNextChild() {
            // node is only null if we already traversed through the tree.
            // do nothing.
            if(node == null)
                return;

            // find the next valid child
            // we consider the cycle complete when we have returned to the head
            // so we stop when node == head and visitedHead
            while(!visitedHead || node != head) {
                if(isElement.test(node) && previous != node) {
                    previous = node;
                    return; // we found the next element
                }

                // always traverse the siblings of the head item
                boolean recurseHead = (node == head && !visitedHead);
                if(recurseHead)
                    visitedHead = true;
                if(recurseHead || (node != head && isRecursive.test(node))) {
                    // recurse on this node
                    PsiElement child = node.getFirstChild();
                    if(child != null) {
                        node = child;
                        continue;
                    }
                    // otherwise this is a leaf, and we can't recurse. Fall-through to
                    // obtaining the next sibling
                }
                // otherwise we are not recursing, get the next sibling of node and continue
                // if we reach the end of the list, traverse up parents
                while(node != head) {
                    PsiElement next = node.getNextSibling();
                    if(next == null) {
                        // traverse upwards to finish recursive call
                        node = node.getParent();
                    } else {
                        // traverse to the next sibling
                        node = next;
                        break;
                    }
                }
            }
            // first time we have exited this loop is when we have traversed the entire
            // tree and are back to head.
            // we set node to null to signal completion.
            node = null;
        }
        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public PsiElement next() {
            PsiElement next = node;
            findNextChild();
            return next;
        }
    }
    @NotNull
    @Override
    public Iterator<PsiElement> iterator() {
        return new PsiListIterator();
    }
}
