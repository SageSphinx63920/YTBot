package dev.sage.tutorial.commands;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HiCommmand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        if(event.getChannelType().equals(ChannelType.TEXT)){
            TextChannel channel = event.getTextChannel();
            Member member = event.getMember();

            if(!member.getUser().isBot()){
                if(event.getMessage().getContentDisplay().equalsIgnoreCase("hi")){
                    channel.sendMessage("Hallo, " + member.getEffectiveName() + "!").queue();
                }
            }

        }

    }

}
