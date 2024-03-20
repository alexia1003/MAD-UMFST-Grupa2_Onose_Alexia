package com.example.lab6_ex4_mad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ParticipantService {
    private List<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public void updateParticipant(Participant participant) {
    }

    public void deleteParticipant(Participant participant) {
        participants.remove(participant);
    }

    public List<Participant> filterByScore(int maxScore) {
        List<Participant> filteredParticipants = new ArrayList<>();
        for (Participant participant : participants) {
            if (participant.getScore() < maxScore) {
                filteredParticipants.add(participant);
            }
        }
        return filteredParticipants;
    }

    public List<Participant> filterByName(char startingLetter) {
        List<Participant> filteredParticipants = new ArrayList<>();
        for (Participant participant : participants) {
            if (participant.getName().charAt(0) == startingLetter) {
                filteredParticipants.add(participant);
            }
        }
        return filteredParticipants;
    }

    public void sortParticipantsByName() {
        Collections.sort(participants, Comparator.comparing(Participant::getName));
    }

    public void sortParticipantsByScore() {
        Collections.sort(participants, Comparator.comparingInt(Participant::getScore));
    }
}
