package dev.sage.tutorial.commands;

import dev.sage.tutorial.TutorialBot;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SayCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        //Wir schauen, ob das der Channel ein TextChannel ist
        if(event.getChannelType().equals(ChannelType.TEXT)){
            //Beginnt unsere Nachricht mir +say?
            if(event.getMessage().getContentDisplay().toLowerCase().startsWith(TutorialBot.prefix + "say")){
                //Member ist das Mitglied des Server, auf dem die Nachricht geschickt wurde
                Member member = event.getMember();
                //TextChannel ist unser Channel in dem die Nachricht geschickt wurde
                TextChannel channel = event.getTextChannel();

                //Das sind alle Satzteile in einer Kette Note: BEGINNT IMMER BEI 0 NICHT 1
                String[] args = event.getMessage().getContentDisplay().split(" ");

                //Brauchen wir, um einen String zusammenzubauen
                StringBuilder stringBuilder = new StringBuilder();

                //Führt alles so lange aus, wie args.length größer oder gleich i ist
                for(int i = 1; i <= args.length - 1; i++){
                    //Fügt unser Satzteil zu builder hinzu + 1 Leerzeichen
                    stringBuilder.append(args[i]).append(" ");
                }

                //Sendet die Nachricht
                channel.sendMessage(stringBuilder.toString()).queue();

                //Löscht die vom User gesendete Nachricht
                event.getMessage().delete().queue();

            }
        }

    }
}
