package dev.sage.tutorial.commands;

import dev.sage.tutorial.TutorialBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class EmbedCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getChannelType().equals(ChannelType.TEXT)){
            if(event.getMessage().getContentDisplay().toLowerCase().startsWith(TutorialBot.prefix + "embed")){
                Member member = event.getMember();
                TextChannel channel = event.getTextChannel();

                String[] args = event.getMessage().getContentDisplay().split(" ");

                StringBuilder stringBuilder = new StringBuilder();

                for(int i = 1; i <= args.length - 1; i++){
                    stringBuilder.append(args[i]).append(" ");
                }

                channel.sendMessageEmbeds(new EmbedBuilder()
                        .setTitle("User Nachricht")
                        .setColor(Color.RED)
                        .setFooter("by " + member.getEffectiveName())
                        .setDescription(stringBuilder.toString())
                                .setThumbnail(member.getEffectiveAvatarUrl())
                        .build()).queue();

                event.getMessage().delete().queue();
            }
        }
    }
}
