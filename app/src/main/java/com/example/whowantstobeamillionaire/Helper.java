package com.example.whowantstobeamillionaire;

import java.util.Arrays;

public class Helper {

  // A 2d array for saving questions with their respective choices.
  // [x][0] is always a questions
  // [x][y] where y > 0 && y <= 4 these are the choices
  private String[][] questions = {
      {"Millionaire debuted in the U.S. in August of which year?", "1992", "1998", "1999", "2000"},
      {"Which of these million-dollar winners, excluding their winnings during the 'Tournament of Champions', has accumulated a larger amount of money?",
          "Dan Blonsky", "Joe Trela", "Kevin Smith", "Ed Toutant"},
      {"How many celebrities were featured in Celebrity Millionaire?", "1", "10", "20", "15"},
      {"How many questions did a contestant have to answer correctly to win a million dollars in the original format?",
          "1", "10", "20", "15"},
      {"Which of these best describes how the amount of money per question increased throughout the game?",
          "Add $50,000 per question", "Rate starts slowly, then gets faster",
          "Roughly tripled per question", "Roughly doubled per question"},
      {"Which of these lifelines did not exist in the original series of Millionaire?",
          "Ask the audience", "Phone-a-friend", "50:50", "Double Dip"},
      {"\"In what children's game are participants chased by someone designated \"It\"?",
          "Tag", "Simon Says", "Charades", "Hopscotch"},
      {"On a radio, stations are changed by using what control?", "Tuning", "Volume", "Bass", "Treble"},
      {"Which material is most dense?", "Silver", "Styrofoam", "Butter", "Gold"},
      {"Which state in the United States is largest by area?",  "Alaska", "California", "Texas", "Hawaii"},
      {"What is Aurora Borealis commonly known as?", "Fairy Dust",
          "Northern Lights", "Book of ages", "a Game of Thrones main character"},
      {"Galileo was an Italian astronomer who", "developed the telescope",
          "discovered four satellites of Jupiter",
          "discovered that the movement of pendulum produces a regular time measurement",
          "All of the above"},
      {"Exposure to sunlight helps a person improve his health because", "the infrared light kills bacteria in the body",
          "resistance power increases",
          "the pigment cells in the skin get stimulated and produce a healthy tan",
          "the ultraviolet rays convert skin oil into Vitamin D"},
      {"Sir Thomas Fearnley Cup is awarded to", "a club or a local sport association for remarkable achievements",
          "amateur athlete, not necessarily an Olympian",
          "National Olympic Committee for outstanding work",
          "None of the above"},
      {"Oscar Awards were instituted in", "1968", "1929", "1901", "1965"},
  };
  private int[] answers = {2, 4, 2, 4, 4, 4, 1, 1, 4, 1, 2, 4, 4, 1, 2};

  public int calculateAnswer(int index, int currentScore) {
    if (index <= 2) {
      return currentScore + 100;
    } else if (index == 3) {
      return currentScore + 200;
    } else if (index == 11) {
      return currentScore + 61000;
    } else {
      return currentScore * 2;
    }
  }

  public Boolean checkAnswer(int index, String answer) {
    return questions[index][answers[index]].equals(answer);
  }

  public String getQuestion(int index) {
    return questions[index][0];
  }

  public String[] getChoices(int index) {
    return Arrays.copyOfRange(questions[index], 1, questions[index].length);
  }

  public int count(){
    return questions.length;
  }
}
