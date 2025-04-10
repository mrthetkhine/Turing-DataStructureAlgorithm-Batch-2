package com.turing.dsa.machinelearning;

import java.util.ArrayList;
import java.util.Random;

class DataSet
{
	double input[];
	double output[];
	
	
	DataSet(double[]input,double[]output)
	{
		this.input = input;
		this.output = output;
	}
}
public class NeuralNetwork {
	
	int noOfInput, noOfHidden,noOfOutput;
	
	double learningRate = 0.1;
	double inputs[];
	double hiddens[];
	double inputHiddenWeight[][];
	
	double outputs[];
	double actualOutput[];
	double hiddenOutputWeight[][];
	double hiddenError[];
	
	double hiddenBias[];
	double outputBias[] ;
	double outputError[];
	
	
	ArrayList<DataSet> trainingSet = new ArrayList<DataSet>();
	public NeuralNetwork(int noOfInput, int noOfHidden,int noOfOutput)
	{
		this.noOfInput = noOfInput;
		this.noOfHidden = noOfHidden;
		this.noOfOutput = noOfOutput;
		
		this.inputs = new double[this.noOfInput];
		
		this.hiddens =new double[this.noOfHidden];
		this.hiddenBias =new double[this.noOfHidden];
		this.hiddenError =new double[this.noOfHidden];
		
		this.outputs =new double[this.noOfOutput];
		this.outputBias =new double[this.noOfOutput];
		this.actualOutput = new double[this.noOfOutput];
		this.outputError =new double[this.noOfOutput];
		
		this.inputHiddenWeight= new double[this.noOfInput][this.noOfHidden];
		this.hiddenOutputWeight =new double[this.noOfHidden][this.noOfInput];
 	}
	void addTrainingExample(double[]input, double[]output)
	{
		this.trainingSet.add(new DataSet(input,output));
	}
	void initWeight()
	{
		Random random =new Random();
		for(int i=0;i<this.inputHiddenWeight.length;i++)
		{
			for(int j=0;j< this.inputHiddenWeight[i].length;j++)
			{
				this.inputHiddenWeight[i][j] = random.nextDouble();
			}
		}
		for(int i=0;i< this.hiddenBias.length;i++)
		{
			this.hiddenBias[i] = random.nextDouble();
		}
		for(int i=0;i< this.hiddenOutputWeight.length;i++)
		{
			for(int j=0;j< this.hiddenOutputWeight[i].length;j++)
			{
				this.hiddenOutputWeight[i][j] = random.nextDouble();
			}
		}
		for(int i=0;i< this.outputBias.length;i++)
		{
			this.outputBias[i]=random.nextDouble();
		}
		
	}
	double trainEpoch()
	{
		ArrayList<Integer> trainingIndex = new ArrayList<>();
		for(int i=0;i< this.trainingSet.size();i++)
		{
			trainingIndex.add(i);
		}
		Random random = new Random();
		double totalMSE = 0;
		for(int i=0;i< this.trainingSet.size();i++)
		{
			int size = trainingIndex.size();
			Integer randomIndex = trainingIndex.get(random.nextInt(size));
			DataSet dataset = this.trainingSet.get(randomIndex);
			totalMSE +=  this.froward(dataset.input,dataset.output);
			this.backpropagate();
			
			trainingIndex.remove(randomIndex);
		}
		totalMSE /= this.trainingSet.size();
		//System.out.println("Total MSE "+totalMSE);
		return totalMSE;
	}
	public double froward(double[]input,double output[])
	{
		this.inputs =input;
		this.actualOutput = output;
		this.forwardInputToHidden();
		double mse = this.forwardHiddenToOutput();
		
		return mse;
	}
	private void forwardInputToHidden() {
		for(int h =0; h < this.noOfHidden;h++)
		{
			this.hiddens[h] = this.hiddenBias[h];
		}
		for(int i=0;i< this.noOfInput;i++ )
		{
			
			for(int h =0; h < this.noOfHidden;h++)
			{
				this.hiddens[h] += this.inputs[i]* this.inputHiddenWeight[i][h];
			}
		}
		for(int h =0; h < this.noOfHidden;h++)
		{
			this.hiddens[h] = sigmod(this.hiddens[h]);
		}
	}
	double forwardHiddenToOutput()
	{
		for(int j =0; j < this.noOfOutput;j++)
		{
			this.outputs[j] = this.outputBias[j];
		}
		for(int i=0;i< this.noOfHidden;i++ )
		{
			
			for(int j =0; j < this.noOfOutput;j++)
			{
				this.outputs[j] += this.hiddens[i]* this.hiddenOutputWeight[i][j];
			}
		}
		double mse = 0;
		for(int j =0; j < this.noOfOutput;j++)
		{
			this.outputs[j] = sigmod(this.outputs[j]);
			
			//Oj*(1-Oj)(T-Oj)
			this.outputError[j] = this.outputs[j]* (1-this.outputs[j])* (this.actualOutput[j]-this.outputs[j]);
			mse+= this.outputError[j];
		}
		for(int j=0;j< this.noOfHidden;j++)
		{
			double errorJK=0.0;
			for(int k=0; k < this.noOfOutput;k++)
			{
				errorJK += this.outputError[k]* this.hiddenOutputWeight[j][k];
			}
			this.hiddenError[j] = this.hiddens[j]*(1-this.hiddens[j])*errorJK;
		}
		return mse;
		
	}
	public void backpropagate()
	{
		for(int i=0;i< this.noOfHidden;i++ )
		{
			
			for(int j =0; j < this.noOfOutput;j++)
			{
				double delta = this.learningRate * this.outputError[j]* this.hiddens[i];
				this.hiddenOutputWeight[i][j]+= delta;
				
			}
			
		}
		for(int j =0; j < this.noOfOutput;j++)
		{
			this.outputBias[j] += this.learningRate* this.outputError[j];
		}
		
		for(int i=0;i< this.noOfInput;i++ )
		{
			
			for(int j =0; j < this.noOfHidden;j++)
			{
				double delta = this.learningRate * this.hiddenError[j]* this.inputs[i];
				this.inputHiddenWeight[i][j]+= delta;
			}
		}
		for(int j =0; j < this.noOfHidden;j++)
		{
			this.hiddenBias[j] += this.learningRate* this.hiddenError[j];
		}
	}
	public double[] test(double input[])
	{
		this.froward(input, new double[this.noOfOutput]);
		return this.outputs;
	}
	public static double sigmod(double x)
	{
		return  1 / (1 + Math.exp(-x));
	}
	public static void main(String[]args)
	{
		NeuralNetwork network = new NeuralNetwork(2,3,1);
		network.initWeight();
		System.out.println("Sigmod "+NeuralNetwork.sigmod(-1000));
		
		network.addTrainingExample(new double[] {0,0},new double[] {0} );
		network.addTrainingExample(new double[] {0,1},new double[] {1} );
		network.addTrainingExample(new double[] {1,0},new double[] {1} );
		network.addTrainingExample(new double[] {1,1},new double[] {0} );
		
		for(int i=0;i< 10000;i++)
		{
			double mse = network.trainEpoch();
			System.out.println("Epoch "+i+ " mse "+mse);
		}
		double[]output = network.test(new double[] {0,0});
		System.out.println("0,0 =>" +output[0]);
		
		network.test(new double[] {1,1});
		System.out.println("1,1 =>" +output[0]);
		
		network.test(new double[] {1,0});
		System.out.println("1,0 =>" +output[0]);
		
		network.test(new double[] {0,1});
		System.out.println("0,1 =>" +output[0]);
	}
}
