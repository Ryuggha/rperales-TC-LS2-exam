package com.drpicox.game.testSteps.enterGame;

import com.drpicox.game.testPost.TestPostForms;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class TypeXIntoThePlayerName extends AbstractPostLineStep {

    private final TestPostForms testPostForms;

    public TypeXIntoThePlayerName(TestPostForms testPostForms) {
        this.testPostForms = testPostForms;
    }

    @Override
    protected String getRegex() {
        return "Type _([^_]+)_ into the _player name_";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        String name = match[1];
        var form = testPostForms.getForm(EnterGameForm.class);
        form.changePlayerName(name);
    }
}
