public class Toggleswitch {

    int iMax = 5;

    volatile boolean toggleswitch = false;

    public void onSwitch() {
        while (iMax != 0) {
            try {
                if (!toggleswitch) {
                    toggleswitch = true;
                    System.out.printf("%s -> Включаю тумблер!\n", Thread.currentThread().getName());
                    iMax--;
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void offSwitch() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(2000);
                if (toggleswitch) {
                    toggleswitch = false;
                    System.out.printf("%s -> Выключаю тумблер!\n", Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}