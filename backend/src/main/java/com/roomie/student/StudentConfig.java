package com.roomie.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.roomie.questionnaire.Questionnaire;



@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student matt = new Student(
                "Matt",
                LocalDate.of(2002, Month.DECEMBER, 21),
                "matt@gmail.com",
                "password",
                "unr",
                List.of("sports", "outdoors", "movies")
            );
            Questionnaire qMatt = new Questionnaire(
                "Clean to me means organized surfaces and no smells.",
                "I usually go for a hike or spend time outside.",
                "I bring things up directly but politely.",
                "Once had a roommate who never took out trash — had a talk, and we made a chore chart.",
                "Dishes left out and loud music late are deal breakers."
            );
            qMatt.setStudent(matt);
            matt.setQuestionare(qMatt);

            Student john = new Student(
                "john",
                LocalDate.of(1999, Month.DECEMBER, 12),
                "john@gmail.com",
                "password",
                "unr",
                List.of("gaming", "late-night", "music")
            );
            Questionnaire qJohn = new Questionnaire(
                "As long as I can find stuff, it’s clean enough.",
                "I stay up gaming and isolate.",
                "Usually let it slide unless it's constant.",
                "Had a loud roommate — I wore headphones and asked for quiet hours.",
                "I can’t live with super tidy roommates who nag."
            );
            qJohn.setStudent(john);
            john.setQuestionare(qJohn);

            Student vanessa = new Student(
                "vanessa",
                LocalDate.of(2003, Month.JUNE, 1),
                "mattosoriox@gmail.com",
                "password",
                "unr",
                List.of("clean", "early bird", "coffee")
            );
            Questionnaire qVanessa = new Questionnaire(
                "Clean means no dust, empty trash, and wiped counters.",
                "I journal and wake up early to reset.",
                "I ask about it in a kind way after a while.",
                "Once I had a passive-aggressive roommate — I asked to talk openly.",
                "I need shared cleanliness and no loud guests late at night."
            );
            qVanessa.setStudent(vanessa);
            vanessa.setQuestionare(qVanessa);

            Student bousso = new Student(
                "bousso",
                LocalDate.of(2000, Month.FEBRUARY, 15),
                "bousso@gmail.com",
                "password",
                "unr",
                List.of("pets", "fashion", "reading")
            );
            Questionnaire qBousso = new Questionnaire(
                "Clean is when the space looks curated and smells good.",
                "I usually sit quietly in my room reading.",
                "I’d leave a note or just clean it myself.",
                "Roommate’s pet kept eating my stuff — I set boundaries kindly.",
                "I need respect for quiet and a visually nice space."
            );
            qBousso.setStudent(bousso);
            bousso.setQuestionare(qBousso);

            Student chad = new Student(
                "chad",
                LocalDate.of(1995, Month.MARCH, 3),
                "chad@gmail.com",
                "password",
                "ucla",
                List.of("gym", "early bird", "clean")
            );
            Questionnaire qChad = new Questionnaire(
                "No clutter, vacuumed floors, and clean counters.",
                "I hit the gym and get more regimented.",
                "I’ll say it right away — calmly but clearly.",
                "Roommate used my stuff — I set clear rules right away.",
                "I need my space respected and bathroom always clean."
            );
            qChad.setStudent(chad);
            chad.setQuestionare(qChad);

            Student leslie = new Student(
                "leslie",
                LocalDate.of(2003, Month.JUNE, 11),
                "leslie@gmail.com",
                "password",
                "unr",
                List.of("quiet", "studious", "vegan")
            );
            Questionnaire qLeslie = new Questionnaire(
                "Clean means serene and simple — nothing in the way.",
                "I keep to myself and study more.",
                "I often let it slide unless it affects studying.",
                "Roommate hosted parties — I moved to the library a lot.",
                "I need peace and minimal disruption."
            );
            qLeslie.setStudent(leslie);
            leslie.setQuestionare(qLeslie);

            Student linsey = new Student(
                "linsey",
                LocalDate.of(2003, Month.JUNE, 11),
                "linsey@gmail.com",
                "password",
                "unr",
                List.of("outdoors", "music", "pets")
            );
            Questionnaire qLinsey = new Questionnaire(
                "As long as it smells okay and surfaces are clean.",
                "I leave for walks and play music.",
                "If I’m annoyed, I try to change the mood with music first.",
                "Roommate never walked our dog — I talked it through.",
                "I need someone okay with pets and shared playlists."
            );
            qLinsey.setStudent(linsey);
            linsey.setQuestionare(qLinsey);

            Student ty = new Student(
                "ty",
                LocalDate.of(2002, Month.AUGUST, 12),
                "ty@gmail.com",
                "password",
                "unr",
                List.of("night owl", "gaming", "foodie")
            );
            Questionnaire qTy = new Questionnaire(
                "I’m messy but not dirty. Trash taken out, dishes eventually done.",
                "I binge eat and stay up late gaming.",
                "I ignore small things until I can't.",
                "Roommate judged my sleep — I stayed chill, then we compromised.",
                "Respect for my schedule and shared fridge space is key."
            );
            qTy.setStudent(ty);
            ty.setQuestionare(qTy);

            Student emily = new Student(
                "emily",
                LocalDate.of(2001, Month.MAY, 17),
                "emily@gmail.com",
                "password",
                "berkeley",
                List.of("yoga", "clean", "plants")
            );
            Questionnaire qEmily = new Questionnaire(
                "Clean is a peaceful, plant-filled space.",
                "I meditate more and light incense.",
                "I prefer subtle hints or cleaning it myself.",
                "Roommate didn’t like my plants — I created a 'plant zone'.",
                "Respecting shared space and quiet mornings is a must."
            );
            qEmily.setStudent(emily);
            emily.setQuestionare(qEmily);

            Student kevin = new Student(
                "kevin",
                LocalDate.of(1998, Month.JULY, 23),
                "kevin@gmail.com",
                "password",
                "unr",
                List.of("sports", "gaming", "night owl")
            );
            Questionnaire qKevin = new Questionnaire(
                "If I can walk through it, it's fine.",
                "I yell at my game screen. Loud, but I cool down quick.",
                "I bring it up once, then drop it.",
                "Roommate used to wake me up early — I slept with earplugs.",
                "Let me be loud at night, and we’re good."
            );
            qKevin.setStudent(kevin);
            kevin.setQuestionare(qKevin);

            Student rachel = new Student(
                "rachel",
                LocalDate.of(2002, Month.SEPTEMBER, 4),
                "rachel@gmail.com",
                "password",
                "ucla",
                List.of("coffee", "reading", "music")
            );
            Questionnaire qRachel = new Questionnaire(
                "Clean = calm. Books organized, no clutter.",
                "I read more and drink tons of coffee.",
                "Depends — if it affects my peace, I say something.",
                "Roommate’s boyfriend basically lived with us — I addressed it directly.",
                "Privacy and silence matter a lot to me."
            );
            qRachel.setStudent(rachel);
            rachel.setQuestionare(qRachel);

            Student andrew = new Student(
                "andrew",
                LocalDate.of(2001, Month.OCTOBER, 19),
                "andrew@gmail.com",
                "password",
                "unlv",
                List.of("foodie", "pets", "gaming")
            );
            Questionnaire qAndrew = new Questionnaire(
                "Clean = sanitized kitchen, especially if I’m cooking.",
                "I play games or experiment with food.",
                "Usually mention it after it happens a couple times.",
                "Roommate hogged the stove — we agreed on cooking times.",
                "Respect for kitchen rules and no judgment on my diet."
            );
            qAndrew.setStudent(andrew);
            andrew.setQuestionare(qAndrew);

            Student sophie = new Student(
                "sophie",
                LocalDate.of(2000, Month.MARCH, 30),
                "sophie@gmail.com",
                "password",
                "unr",
                List.of("clean", "morning person", "gym")
            );
            Questionnaire qSophie = new Questionnaire(
                "Floors clean, dishes washed daily, fresh air.",
                "I wake up earlier and go for a run.",
                "I bring it up the moment it bothers me.",
                "Roommate slept in and hated mornings — we didn’t click.",
                "Shared cleanliness and morning habits are top priority."
            );
            qSophie.setStudent(sophie);
            sophie.setQuestionare(qSophie);

            Student brandon = new Student(
                "brandon",
                LocalDate.of(1999, Month.DECEMBER, 8),
                "brandon@gmail.com",
                "password",
                "usc",
                List.of("gym", "sports", "movies")
            );
            Questionnaire qBrandon = new Questionnaire(
                "Clean = no shoes indoors, vacuumed floors.",
                "I watch a lot of sports and work out more.",
                "I’ll mention it during a game break — casually.",
                "Roommate left gear everywhere — we split cleaning duties.",
                "Shared interest in sports helps a lot."
            );
            qBrandon.setStudent(brandon);
            brandon.setQuestionare(qBrandon);

            Student diana = new Student(
                "diana",
                LocalDate.of(2002, Month.NOVEMBER, 15),
                "diana@gmail.com",
                "password",
                "unr",
                List.of("quiet", "early bird", "coffee")
            );
            Questionnaire qDiana = new Questionnaire(
                "Neat, smells like coffee and peace.",
                "I make coffee, journal, and sleep early.",
                "I’ll mention things directly — in the morning preferably.",
                "Loud roommate at 2AM — I just moved rooms eventually.",
                "Early bedtime and quiet mornings are sacred."
            );
            qDiana.setStudent(diana);
            diana.setQuestionare(qDiana);

            Student lucas = new Student(
                "lucas",
                LocalDate.of(2003, Month.JANUARY, 6),
                "lucas@gmail.com",
                "password",
                "ucla",
                List.of("gaming", "night owl", "fast food")
            );
            Questionnaire qLucas = new Questionnaire(
                "I don’t care about mess unless it smells.",
                "I stay up gaming and door stays closed.",
                "I avoid confrontation unless it’s serious.",
                "Roommate was passive-aggressive — I ghosted him.",
                "I need my late night time without being judged."
            );
            qLucas.setStudent(lucas);
            lucas.setQuestionare(qLucas);

            Student megan = new Student(
                "megan",
                LocalDate.of(2001, Month.APRIL, 22),
                "megan@gmail.com",
                "password",
                "unr",
                List.of("studious", "pets", "clean")
            );
            Questionnaire qMegan = new Questionnaire(
                "Organized space and no weird smells.",
                "I cuddle my cat and read a lot.",
                "If it impacts my studies, I bring it up.",
                "Roommate didn’t respect quiet hours — I emailed management.",
                "Study time and pet boundaries matter most."
            );
            qMegan.setStudent(megan);
            megan.setQuestionare(qMegan);



            repository.saveAll(List.of(matt, john, vanessa, bousso, chad, leslie, linsey, ty, emily, kevin, rachel, andrew, sophie, brandon, diana, lucas, megan));
        };
    };
}

