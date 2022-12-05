package thb.fbi.parser;

import java.util.Collection;
import java.util.Collections;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import thb.fbi.parser.antlr.LegV8BaseListener;
import thb.fbi.parser.antlr.LegV8Parser.DeclarationContext;
import thb.fbi.parser.antlr.LegV8Parser.ImmediateInstructionContext;
import thb.fbi.parser.antlr.LegV8Parser.InvocationContext;
import thb.fbi.parser.antlr.LegV8Parser.MainContext;
import thb.fbi.parser.antlr.LegV8Parser.RegisterContext;

/**
 * Listener for walking through Syntax Tree and adding styles to each node
 */
public class SyntaxHighlighter extends LegV8BaseListener {

    StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
    int lastEnd = 0;
    int textlength = 0;

    public SyntaxHighlighter(int textlength) {
        this.textlength = textlength;
    }

    /**
     * return styles of all nodes
     * @return stylespan for all nodes/ complete text
     */
    public StyleSpans<Collection<String>> getStyles() {
        spansBuilder.add(Collections.emptyList(), textlength - lastEnd);
		return spansBuilder.create();
	}

    /**
     * add style of node in sytle collection to apply later 
     * @param node node to add style to
     * @param style css-class style to apply
     */
    private void addStyle (TerminalNode node, String style) {
        if(node != null) {
            Token token = node.getSymbol();
            int spacing = token.getStartIndex() - lastEnd;


    System.out.print("token != null     ");

            if(spacing > 0) {
                spansBuilder.add(Collections.emptyList(), spacing);

                int gap = token.getText().length();
                spansBuilder.add(Collections.singleton(style), gap);
                lastEnd = token.getStopIndex() + 1;
        System.out.print("spacing > 0     ");
            }
        }
    }

    @Override
    public void enterMain(MainContext ctx) {
        lastEnd = 0;
    }

    @Override
    public void enterImmediateInstruction(ImmediateInstructionContext ctx) {
        addStyle(ctx.getToken(0, 0), "instruction");
    }

    @Override
    public void exitImmediateInstruction(ImmediateInstructionContext ctx) {
        
    }

    @Override
    public void enterRegister(RegisterContext ctx) {
        addStyle(ctx.REGISTER(), "instruction");
    }

    @Override
    public void enterDeclaration(DeclarationContext ctx) {
        addStyle(ctx.JumpDeclaration(), "jump-mark");
    }

    @Override
    public void enterInvocation(InvocationContext ctx) {
        addStyle(ctx.JumpInvocation(), "jump-mark");
    }

}
