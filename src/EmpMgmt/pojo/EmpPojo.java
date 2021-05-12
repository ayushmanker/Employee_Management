
package EmpMgmt.pojo;

public class EmpPojo
{

    @Override
    public String toString() {
        return  empno +"\t"+ename + "\t"+ sal +"\n";
    }

    public int getEmpno()
    {
        return empno;
    }

    public void setEmpno(int empno)
    {
        this.empno = empno;
    }

    public String getEname()
    {
        return ename;
    }

    public void setEname(String ename)
    {
        this.ename = ename;
    }

    public double getSal()
    {
        return sal;
    }

    public void setSal(double sal)
    {
        this.sal = sal;
    }
    private int empno;
    private String ename;
    private double sal;
}
