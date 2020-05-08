package q009;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PrimeFactorization extends Thread {
    private BigInteger number;
    private List<BigInteger> primes;

    public PrimeFactorization(String number) {
        this.number = BigInteger.valueOf(Long.parseLong(number));
    }

    public BigInteger getNumber() {
        return number;
    }

    public List<BigInteger> getPrimes() {
        return primes;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        primes = calc();
    }

    private List<BigInteger> calc() {
        List<BigInteger> primeNumbers = new ArrayList<>(Collections.emptyList());
        BigInteger num = number;
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(number) <= 0; i = i.add(BigInteger.ONE)) {
            if (num.remainder(i).compareTo(BigInteger.ZERO) != 0) {
                continue;
            }
            do {
                num = num.divide(i);
            } while (num.remainder(i).compareTo(BigInteger.ZERO) == 0);
            primeNumbers.add(i);
        }
        return primeNumbers;
    }
}
