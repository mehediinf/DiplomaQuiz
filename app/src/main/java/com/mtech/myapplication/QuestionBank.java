package com.mtech.myapplication;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionBank {

    public static ArrayList<Question> getQuestions() {
        ArrayList<Question> banglaQuestions = new ArrayList<>();
        ArrayList<Question> englishQuestions = new ArrayList<>();
        ArrayList<Question> finalQuestions = new ArrayList<>();

        // বাংলা প্রশ্ন
        banglaQuestions.add(new Question("বাংলা", "পদ্মা সেতুর দৈর্ঘ্য কত?", new String[]{"৬.১৫ কিমি", "৭.১০ কিমি", "৮.২৫ কিমি", "৫.৪০ কিমি"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় সংগীত কে রচনা করেছেন?", new String[]{"কাজী নজরুল ইসলাম", "রবীন্দ্রনাথ ঠাকুর", "সুকান্ত ভট্টাচার্য", "মাইকেল মধুসূদন দত্ত"}, 1));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের মুদ্রার নাম কী?", new String[]{"টাকা", "রূপি", "ডলার", "ইউরো"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রধান নদীর নাম কী?", new String[]{"পদ্মা", "যমুনা", "মেঘনা", "সবগুলো"}, 3));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশ স্বাধীনতা লাভ করে কোন সালে?", new String[]{"১৯৭১", "১৯৫২", "১৯৪৭", "১৯৬৫"}, 0));
        banglaQuestions.add(new Question("বাংলা", "জাতীয় শহীদ দিবস কবে পালিত হয়?", new String[]{"২১ ফেব্রুয়ারি", "২৬ মার্চ", "১৬ ডিসেম্বর", "১৫ আগস্ট"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের প্রধান ফসল কোনটি?", new String[]{"ধান", "পাট", "গম", "আলু"}, 0));
        banglaQuestions.add(new Question("বাংলা", "বাংলাদেশের জাতীয় মাছ কোনটি?", new String[]{"ইলিশ", "পাঙাশ", "রুই", "কাতলা"}, 0));
        banglaQuestions.add(new Question("বাংলা", "কোনটি বাংলাদেশের জাতীয় বৃক্ষ?", new String[]{"বটগাছ", "আমগাছ", "কড়ইগাছ", "জামগাছ"}, 0));

        // ইংরেজি প্রশ্ন
        englishQuestions.add(new Question("ইংরেজি", "Who is known as the father of Computer Science?", new String[]{"Alan Turing", "Charles Babbage", "John Von Neumann", "Ada Lovelace"}, 1));
        englishQuestions.add(new Question("ইংরেজি", "What is the largest planet in our solar system?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 2));
        englishQuestions.add(new Question("ইংরেজি", "What is the boiling point of water?", new String[]{"50°C", "100°C", "200°C", "0°C"}, 1));
        englishQuestions.add(new Question("ইংরেজি", "Which country is known as the Land of the Rising Sun?", new String[]{"China", "Japan", "Korea", "India"}, 1));
        englishQuestions.add(new Question("ইংরেজি", "Which element has the chemical symbol 'O'?", new String[]{"Oxygen", "Gold", "Hydrogen", "Iron"}, 0));
        englishQuestions.add(new Question("ইংরেজি", "What is the smallest unit of life?", new String[]{"Atom", "Molecule", "Cell", "Tissue"}, 2));
        englishQuestions.add(new Question("ইংরেজি", "Which continent has the highest number of countries?", new String[]{"Asia", "Africa", "Europe", "South America"}, 1));
        englishQuestions.add(new Question("ইংরেজি", "Who wrote 'Romeo and Juliet'?", new String[]{"William Wordsworth", "William Shakespeare", "Charles Dickens", "Jane Austen"}, 1));
        englishQuestions.add(new Question("ইংরেজি", "What is the speed of light?", new String[]{"300,000 km/s", "150,000 km/s", "200,000 km/s", "250,000 km/s"}, 0));
        englishQuestions.add(new Question("ইংরেজি", "Which organ in the human body is responsible for pumping blood?", new String[]{"Brain", "Heart", "Lungs", "Liver"}, 1));

        // Randomize and Select
        Collections.shuffle(banglaQuestions);
        Collections.shuffle(englishQuestions);

        finalQuestions.addAll(banglaQuestions.subList(0, 3)); // 3 Bangla questions
        finalQuestions.addAll(englishQuestions.subList(0, 2)); // 2 English questions

       // Collections.shuffle(finalQuestions); // Shuffle final list

        return finalQuestions;
    }
}






