package mx.edu.ulsaoaxaca.libres.examenordinario.models;

import java.util.Random;

public class Evaluador {
	public void asigData(Integer n, int i, PResp p [],  Respuesta[] r, int indice)
	{
		if(n==1)
		{
			if (indice==0) {
				r[0].setIsTheRightAnswer(true);
			}
			p[i].setResps(new Respuesta[] {r[0]});
		}
		else if(n==2)
		{
			if (indice==0) {
				r[0].setIsTheRightAnswer(true);
			}else if(indice==1) {
				r[1].setIsTheRightAnswer(true);
			}
			p[i].setResps(new Respuesta[] {r[0], r[1]});
		}
		else if(n==3)
		{
			if (indice==0) {
				r[0].setIsTheRightAnswer(true);
			}else if(indice==1) {
				r[1].setIsTheRightAnswer(true);
			}else if(indice==2) {
				r[2].setIsTheRightAnswer(true);
			}
			p[i].setResps(new Respuesta[] {r[0], r[1], r[2]});
		}
		else if(n==4)
		{
			if (indice==0) {
				r[0].setIsTheRightAnswer(true);
			}else if(indice==1) {
				r[1].setIsTheRightAnswer(true);
			}else if(indice==2) {
				r[2].setIsTheRightAnswer(true);
			}else if(indice==3) {
				r[3].setIsTheRightAnswer(true);
			}
			Random random = new Random();
			int valorDado = random.nextInt(6);
			p[i].setResps(new Respuesta[] {r[0], r[1], r[2],r[3]});
		}
		else if(n==5)
		{
			if (indice==0) {
				r[0].setIsTheRightAnswer(true);
			}else if(indice==1) {
				r[1].setIsTheRightAnswer(true);
			}else if(indice==2) {
				r[2].setIsTheRightAnswer(true);
			}else if(indice==3) {
				r[3].setIsTheRightAnswer(true);
			}else if(indice==4) {
				r[4].setIsTheRightAnswer(true);
			}
			p[i].setResps(new Respuesta[] {r[0], r[1], r[2], r[3], r[4]});
		}
		else if(n==6)
		{
			if (indice==0) {
				r[0].setIsTheRightAnswer(true);
			}else if(indice==1) {
				r[1].setIsTheRightAnswer(true);
			}else if(indice==2) {
				r[2].setIsTheRightAnswer(true);
			}else if(indice==3) {
				r[3].setIsTheRightAnswer(true);
			}else if(indice==4) {
				r[4].setIsTheRightAnswer(true);
			}else if(indice==5) {
				r[5].setIsTheRightAnswer(true);
			}
			p[i].setResps(new Respuesta[] {r[0], r[1],  r[2], r[3], r[4], r[5]});
		}
		else if(n==7)
		{
			if (indice==0) {
				r[0].setIsTheRightAnswer(true);
			}else if(indice==1) {
				r[1].setIsTheRightAnswer(true);
			}else if(indice==2) {
				r[2].setIsTheRightAnswer(true);
			}else if(indice==3) {
				r[3].setIsTheRightAnswer(true);
			}else if(indice==4) {
				r[4].setIsTheRightAnswer(true);
			}else if(indice==5) {
				r[5].setIsTheRightAnswer(true);
			}else if(indice==6) {
				r[6].setIsTheRightAnswer(true);
			}
			p[i].setResps(new Respuesta[] {r[0], r[1],  r[2], r[3], r[4], r[5], r[6]});
		}
		else if(n==8)
		{
			if (indice==0) {
				r[0].setIsTheRightAnswer(true);
			}else if(indice==1) {
				r[1].setIsTheRightAnswer(true);
			}else if(indice==2) {
				r[2].setIsTheRightAnswer(true);
			}else if(indice==3) {
				r[3].setIsTheRightAnswer(true);
			}else if(indice==4) {
				r[4].setIsTheRightAnswer(true);
			}else if(indice==5) {
				r[5].setIsTheRightAnswer(true);
			}else if(indice==6) {
				r[6].setIsTheRightAnswer(true);
			}else if(indice==7) {
				r[7].setIsTheRightAnswer(true);
			}
			p[i].setResps(new Respuesta[] {r[0], r[1],  r[2], r[3], r[4], r[5], r[6], r[7]});
		}
		else if(n==9)
		{
			if (indice==0) {
				r[0].setIsTheRightAnswer(true);
			}else if(indice==1) {
				r[1].setIsTheRightAnswer(true);
			}else if(indice==2) {
				r[2].setIsTheRightAnswer(true);
			}else if(indice==3) {
				r[3].setIsTheRightAnswer(true);
			}else if(indice==4) {
				r[4].setIsTheRightAnswer(true);
			}else if(indice==5) {
				r[5].setIsTheRightAnswer(true);
			}else if(indice==6) {
				r[6].setIsTheRightAnswer(true);
			}else if(indice==7) {
				r[7].setIsTheRightAnswer(true);
			}else if(indice==8) {
				r[8].setIsTheRightAnswer(true);
			}
			p[i].setResps(new Respuesta[] {r[0], r[1],  r[2], r[3], r[4], r[5], r[6], r[7], r[8]});
		}
		else if(n==10)
		{
			if (indice==0) {
				r[0].setIsTheRightAnswer(true);
			}else if(indice==1) {
				r[1].setIsTheRightAnswer(true);
			}else if(indice==2) {
				r[2].setIsTheRightAnswer(true);
			}else if(indice==3) {
				r[3].setIsTheRightAnswer(true);
			}else if(indice==4) {
				r[4].setIsTheRightAnswer(true);
			}else if(indice==5) {
				r[5].setIsTheRightAnswer(true);
			}else if(indice==6) {
				r[6].setIsTheRightAnswer(true);
			}else if(indice==7) {
				r[7].setIsTheRightAnswer(true);
			}else if(indice==8) {
				r[8].setIsTheRightAnswer(true);
			}else if(indice==9) {
				r[9].setIsTheRightAnswer(true);
			}
			p[i].setResps(new Respuesta[] {r[0], r[1],  r[2], r[3], r[4], r[5], r[6], r[7], r[8], r[9]});
		}
	}
}
