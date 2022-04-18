package dev.sage.tutorial;

import dev.sage.tutorial.commands.EmbedCommand;
import dev.sage.tutorial.commands.HiCommmand;
import dev.sage.tutorial.commands.SayCommand;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class TutorialBot {

    //Unser Prefix für den Bot
    public static final String prefix = "+";

    //Die Start-Methode des Programms
    public static void main(String[] args){

        //Das ist unser Builder, dort können mir Sachen ändern beim Starten
        JDABuilder builder = JDABuilder.createDefault("TOKEN");

        //Hier setzten wir den Online Status + Activity, die der Bot hat
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("minecraft mit Freunden!"));

        //Wir registrieren unsere Events
        //Falls unsere Klasse HelloCommand heißen würde, müssen wir hier auch new HelloCommand() schreiben
        builder.addEventListeners(new HiCommmand());
        builder.addEventListeners(new SayCommand());
        builder.addEventListeners(new EmbedCommand());

        //Wir starten unseren Bot
        try {
            builder.build();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }

    }

}
