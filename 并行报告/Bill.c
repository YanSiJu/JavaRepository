#include<stdio.h>
double trap (double left_endpt,double right_endpt,int trap_count,double base_len);
double f (double x);

int main(void){
		double left_endpt;
		double right_endpt;
		int trap_count;
		double base_len;
		double integral;

		printf("Enter a, b ,and n\n");
		scanf("%lf",&left_endpt);
		scanf("%lf",&right_endpt);
		scanf("%d",&trap_count);

		base_len=(right_endpt-left_endpt)/trap_count;
	        integral=trap(left_endpt,right_endpt,trap_count,base_len);
		printf("With n=%d trapezoids,our estimate\n",trap_count);
		printf("of the integral from %f to %f = %.15f\n",left_endpt,right_endpt,integral);
		system("pause");
		return 0;

}
double f (double x){
	return 4/(1+x*x);

}
double trap (double left_endpt,double right_endpt,int trap_count,double base_len){
	double estimate,x;
	int i;
    	estimate=(f(left_endpt)+f(right_endpt))/2.0;
	for(i=1;i<=trap_count-1;i++)
	{x=left_endpt+i*base_len;
	estimate+=f(x);
	}
	estimate= estimate*base_len;
	return estimate;
}