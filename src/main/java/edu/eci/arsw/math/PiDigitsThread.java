package edu.eci.arsw.math;

class PiDigitsThread extends Thread {
    private int start;
    private int count;
    private byte[] digits;
    private int offset;

    public PiDigitsThread(int start, int count, byte[] digits, int offset) {
        this.start = start;
        this.count = count;
        this.digits = digits;
        this.offset = offset;
    }

    @Override
    public void run() {
        byte[] threadDigits = PiDigits.getDigits(start, count);
        System.arraycopy(threadDigits, 0, digits, offset, threadDigits.length);
    }
}