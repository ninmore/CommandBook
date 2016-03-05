package com.sk89q.jinglenote.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.sk89q.jinglenote.Instrument;
import com.sk89q.jinglenote.JingleNotePlayer;
import com.sk89q.jinglenote.JingleSequencer;
import com.sk89q.jinglenote.JingleSequencer.Note;

public class BukkitJingleNotePlayer extends JingleNotePlayer {

    public BukkitJingleNotePlayer (String player, JingleSequencer seq) {
        super(player, seq);
    }

    Player p = null;

    @Override
    public void play (Note note)  {

        if (p == null || !p.isOnline())
            p = Bukkit.getPlayerExact(player);

        if (p == null || !p.isOnline() || note == null)
            return;

        p.playSound(p.getLocation(), toSound(note.getInstrument()), note.getVelocity(), note.getNote());
    }

    public Sound toSound(Instrument instrument) {

        switch(instrument) {
            case BASEDRUM:
                return Sound.BLOCK_NOTE_BASEDRUM;
            case BASS:
                return Sound.BLOCK_NOTE_PLING;
            case HARP:
                return Sound.BLOCK_NOTE_HARP;
            case HAT:
                return Sound.BLOCK_NOTE_HAT;
            case PLING:
                return Sound.BLOCK_NOTE_PLING;
            case SNARE:
                return Sound.BLOCK_NOTE_SNARE;
            default:
                return Sound.BLOCK_NOTE_HARP;
        }
    }
}