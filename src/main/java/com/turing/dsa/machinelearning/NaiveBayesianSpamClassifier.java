package com.turing.dsa.machinelearning;

import java.util.ArrayList;
import java.util.HashMap;
/*
 *
 *train_spam = ['send us your password', 'review our website', 'send your password', 'send us your account']
  train_ham = ['Your activity report','benefits physical activity', 'the importance vows']

 test_emails = {'spam':['renew your password', 'renew your vows'], 'ham':['benefits of our account', 'the importance of physical activity']}

 * */
public class NaiveBayesianSpamClassifier {

	ArrayList<String> spamTrainingSet = new ArrayList<>();
	ArrayList<String> hamTrainingSet = new ArrayList<>();
	
	ArrayList<String> spamTestSet = new ArrayList<>();
	ArrayList<String> hamTestgSet = new ArrayList<>();
	
	ArrayList<String> stopWord = new ArrayList<>();
	ArrayList<String> wordList = new ArrayList<>();
	
	HashMap<String,Double> wordProb = new HashMap<>();
	HashMap<String,Double> wordSpamProb = new HashMap<>();
	HashMap<String,Double> wordHamProb = new HashMap<>();
	
	double probSpam,probHam;
	
	NaiveBayesianSpamClassifier()
	{
		this.stopWord.add("us");
		this.stopWord.add("your");
		this.stopWord.add("our");
		this.stopWord.add("the");
	}
	double getWordSpamProab(String word)
	{
		return this.wordSpamProb.get(word) == null?0.00001:this.wordSpamProb.get(word);
	}
	double getWordHamProab(String word)
	{
		return this.wordHamProb.get(word) == null?0.00001:this.wordHamProb.get(word);
	}
	double getWordProab(String word)
	{
		return this.wordProb.get(word) == null?0.00001:this.wordProb.get(word);
	}
	public void addSpamTraining(String spam)
	{
		this.spamTrainingSet.add(spam.toLowerCase());
	}
	public void addHamTraining(String ham)
	{
		this.hamTrainingSet.add(ham.toLowerCase());
	}
	public void buildWordList()
	{
		for(String spam : this.spamTrainingSet)
		{
			String[] words = spam.toLowerCase().split(" ");
			for(String word : words)
			{
				if(!this.stopWord.contains(word))
				{
					this.wordList.add(word);
				}
			}
		}
		for(String ham : this.hamTrainingSet)
		{
			String[] words = ham.toLowerCase().split(" ");
			for(String word : words)
			{
				if(!this.stopWord.contains(word))
				{
					this.wordList.add(word);
				}
			}
		}
	}
	void buildWordProb()
	{
		//P(word)= document with word/total_document
		int total = this.spamTrainingSet.size() + this.hamTrainingSet.size();
		for(String word : this.wordList)
		{
			//System.out.println("Word "+word);
			double noOfDoc = this.noOfDocWithWord(word);
			double prob = 0.0000001;
			
			if(noOfDoc>0)
			{
				prob = noOfDoc/total;
			}
			this.wordProb.put(word, prob);
		}
		for(String word: this.wordList)
		{
			//p(word,spam)=P('word',spam)* P(spam)/P(word)
			double noOfDocInSpam= this.noOfSpamDocWithWord(word);
			double probOfWordInSpam = 0.0000001;
			
			if(noOfDocInSpam>0)
			{
				probOfWordInSpam = noOfDocInSpam/ this.spamTrainingSet.size();
			}
			this.wordSpamProb.put(word, probOfWordInSpam);
			
			double noOfDocInHam= this.noOfHamDocWithWord(word);
			double probOfWordInHam =  0.0000001;
			if(noOfDocInHam >0 )
			{
				probOfWordInHam = noOfDocInHam / this.hamTrainingSet.size();
			}
			this.wordHamProb.put(word, probOfWordInHam);
		}
	}
	int noOfSpamDocWithWord(String word)
	{
		int count = 0;
		for(String spam: this.spamTrainingSet )
		{
			if(spam.contains(word))
			{
				count++;
			}
		}
		return count;
	}
	int noOfHamDocWithWord(String word)
	{
		int count = 0;
		for(String ham: this.hamTrainingSet )
		{
			if(ham.contains(word))
			{
				count++;
			}
		}
		return count;
	}
	int noOfDocWithWord(String word)
	{
		int count = this.noOfSpamDocWithWord(word)+this.noOfHamDocWithWord(word);
		return count;
	}
	//example https://www.kaggle.com/code/samuelcortinhas/nlp5-text-classification-with-naive-bayes
	//p(word,spam)=P('word',spam)* P(spam)/P(word)
					
	void train()
	{
		int total = this.spamTrainingSet.size() + this.hamTrainingSet.size();
		this.probSpam = ((double)this.spamTrainingSet.size() / total);
		this.probHam = ((double)this.hamTrainingSet.size() / total);
		
		//System.out.println("Total "+total);	
		//System.out.println("probab spam "+this.probSpam+" ProbHam "+this.probHam);
		//P(word)= document with word/total_document
		//p(word,spam) = document with word in spam/ spam document
		this.buildWordList();
		this.buildWordProb();
	}
	String classify(String email)
	{
		String label = "";
		email = email.toLowerCase();
		String words[] = email.split(" ");
		
		double spamProb = 1;
		double hamProab = 1;
		/*
		 * P(word,spam) = P(spam,word)*P(spam)/P(word)
		 * */
		for(String word:words)
		{
			if(!this.stopWord.contains(word))
			{
				//System.out.println("Word "+word +" spam "+ this.getWordSpamProab(word) +" prob "+this.probSpam+ " getWordpro "+ this.getWordProab(word));
				double spam = ( this.getWordSpamProab(word) * this.probSpam / this.getWordProab(word));
				double ham = (this.getWordHamProab(word) * this.probHam / this.getWordProab(word));
				//System.out.println("Word "+word +" spam "+spam +" Ham "+ ham);
				
				spamProb *= spam;
				hamProab *= ham;
			}
			
		}
	
		return spamProb> hamProab?"Spam":"Ham";
	}
	public static void main(String[]args)
	{
		NaiveBayesianSpamClassifier model= new NaiveBayesianSpamClassifier();
		model.addSpamTraining("send us your password");
		model.addSpamTraining("review our website");
		model.addSpamTraining("send your password");
		model.addSpamTraining("send us your account");
		
		model.addHamTraining("Your activity report");
		model.addHamTraining("benefits physical activity");
		model.addHamTraining("the importance vows");
		
		model.train();
		
		/*
		for(String word : model.wordList)
		{
			System.out.println("Word "+word + " Prob " +model.wordProb.get(word) 
			+" spam "+model.wordSpamProb.get(word) 
			+" ham "+model.wordHamProb.get(word));
		}
		*/
		//test_emails = {'spam':['renew your password', 'renew your vows'], 'ham':['benefits of our account', 'the importance of physical activity']}
		System.out.println("Test Spam "+model.classify("renew your password"));	
		System.out.println("Test Spam "+model.classify("send us your password"));	
		
		System.out.println("Test Ham "+model.classify("benefits of our activity"));	
		System.out.println("Test Ham "+model.classify("the importance of physical activity"));	
	}
}
