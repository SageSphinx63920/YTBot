package dev.sage.tutorial.commands;

import dev.sage.tutorial.TutorialBot;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EmptyCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getChannelType().equals(ChannelType.TEXT)){
            if(event.getMessage().getContentDisplay().equalsIgnoreCase(TutorialBot.prefix + "<command>")){
                Member member = event.getMember();
                TextChannel channel = event.getTextChannel();


            }
        }
    }
}
