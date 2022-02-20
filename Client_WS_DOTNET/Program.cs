using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Client_WS_DOTNET
{
    class Program
    {
        static void Main(string[] args)
        {
            SR1.BanqueServiceClient stub = new SR1.BanqueServiceClient();
            Console.WriteLine(stub.ConversionEuroToDH(80));
            SR1.compte cp = stub.getCompte(5);
            Console.WriteLine(cp.code);
            Console.WriteLine(cp.solde);
            SR1.compte[] cpts = stub.listComptes();
            foreach(var c in cpts)
            {
                Console.WriteLine("-------------");
                Console.WriteLine(cp.code);
                Console.WriteLine(cp.solde);
            }
            Console.ReadLine();
        }
    }
}
