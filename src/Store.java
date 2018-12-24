import java.util.Scanner;
class Store {
    Home home;
    StoreDetails.AddItems addItems;
    class Login {
        public String userid;
        public String name;
        public String password;
        public Login(String userid, String name, String password) {
            this.userid = userid;
            this.name = name;
            this.password = password;
        }
        public Login() {
        }
    }
    class Home {
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        Login login[] = new Login[50];
        StoreDetails sd=new StoreDetails();
        public void process1() {
            setupSample();
            while (true) {
                System.out.println("1:Login");
                System.out.println("2.Registration");
                System.out.println("3.Exit");
                System.out.println("Enter your Choice");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        login();
                        break;
                    case 2:
                        registration();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        }
        private void setupSample() {
            login[index++] = new Login("admin", "Admin", "manager");
            login[index++] = new Login("suneel", "Suneel G", "suneel");
        }
        void login() {
            setupSample();
            while (true) {
                System.out.println("1.Admin");
                System.out.println("2.User");
                System.out.println("3.Back");
                System.out.println("Enter your choice");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        adminlogin();
                        break;
                    case 2:
                        userlogin();
                        break;
                    case 3:
                        home.process1();
                        break;
                }
            }
        }
        void adminlogin() {
            System.out.println("Enter the User ID Here");
            String userid = scanner.next();
            System.out.println("Enter the Password Here");
            String password = scanner.next();
            for (int i = 0; i < login.length; i++) {
                if (login[i] != null) {
                    if (login[i].userid.equals(userid) && login[i].password.equals(password)) {
                        System.out.println("Hello" + login[i].name);

                        addItems = sd.new AddItems();
                        addItems.process();
                    }
                }
            }
        }
        void userlogin() {
            System.out.println("Enter the User ID Here");
            String userid = scanner.next();
            System.out.println("Enter the Password Here");
            String password = scanner.next();
            for (int i = 0; i < login.length; i++) {
                if (login[i] != null) {
                    if (login[i].userid.equals(userid) && login[i].password.equals(password)) {
                        System.out.println("Hello" + login[i].name);
                        sd.cart = sd.new Cart();
                        sd.cart.process2();
                    }
                }
            }
        }
        void registration() {
            Login login1 = new Login();
            System.out.println("Enter the user ID");
            login1.userid = scanner.next();
            System.out.println("Enter the name");
            login1.name = scanner.next();
            System.out.println("Enter the password");
            login1.password = scanner.next();
            login[index] = login1;
            index++;
        }
    }
    class StoreDetails {
        Cart cart;
        class Item {
            int itemid;
            String name;
            double price;
            int quantity;
            Item() {
            }
            Item(int itemid, String name, double price) {
                this.itemid = itemid;
                this.name = name;
                this.price = price;
            }
            void print() {
                System.out.println("Item Id:" + itemid + " " + "Item Name:" + name + " " + "Item Price:" + price);
            }
        }
        public class AddItems {
            int nextItemIndex = 0;
            Item[] items = new Item[50];
            Scanner scanner = new Scanner(System.in);
            public void process() {
                setupSample();
                while (true) {
                    System.out.println("Please following Commands");
                    System.out.println("1.Show Items");
                    System.out.println("2. Add Items");
                    System.out.println("3.Modify Items");
                    System.out.println("4.Delete items");
                    System.out.println("5.Log Out");
                    System.out.println("Enter Your Choice");
                    int input = scanner.nextInt();
                    switch (input) {
                        case 1:
                            showItems();
                            break;
                        case 2:
                            addItems();
                            break;
                        case 3:
                            modifyItems();
                            break;
                        case 4:
                            deleteItems();
                            break;
                        case 5:
                            logout();
                            break;
                    }
                }
            }
            private void setupSample() {
                items[nextItemIndex++] = new Item(1, "Bottle", 650.0);
                items[nextItemIndex++] = new Item(2, "Speakers", 650.0);
                items[nextItemIndex++] = new Item(3, "UPS", 2650.0);
                items[nextItemIndex++] = new Item(4, "Sony Tv", 35650.0);
            }
            void showItems() {
                boolean found = false;
                System.out.println("-----------------------------------");
                for (int i = 0; i < items.length; i++) {
                    if (items[i] != null) {
                        items[i].print();
                        found = true;
                    }
                }
                if (!found)
                    System.out.println("No Records found");
                System.out.println("-----------------------------------");
            }
            void addItems() {
                Item item = new Item();
                System.out.println("Enter the Item ID");
                item.itemid = scanner.nextInt();
                System.out.println("Enter the Item Name");
                item.name = scanner.next();
                System.out.println("Enter the Item price");
                item.price = scanner.nextDouble();
                items[nextItemIndex] = item;
                nextItemIndex++;
            }
            void modifyItems() {
                System.out.println("Enter the Item ID :");
                int itemid = scanner.nextInt();
                for (int i = 0; i < items.length; i++) {
                    if (items[i] != null) {
                        if (items[i].itemid == itemid) {
                            System.out.println("Enter the Item Name");
                            items[i].name = scanner.next();
                            System.out.println("Enter the Price");
                            items[i].price = scanner.nextDouble();
                        }
                    }
                }
            }
            void deleteItems() {
                System.out.println("Enter the which Item delete");
                int itemid = scanner.nextInt();
                boolean found = false;
                for (int i = 0; i < items.length; i++) {
                    if (items[i] != null) {
                        if (items[i].itemid == itemid) {
                            items[i] = null;
                            found = true;
                        }
                    }
                }
                if (!found) {
                    System.out.println("Element not found");
                }
            }
            void logout() {
                System.out.println("Successfully logout");
                Home store = new Home();
                store.login();
            }
        }
        class Order {
            int orderid;
            String item_name;
            void print() {
                System.out.println("------------------------------");
                System.out.println("Order ID   "+orderid);
                for (int i = 0; i < addItems.items.length; i++) {
                    if (addItems.items[i] != null) {
                        if (addItems.items[i].name.equals(item_name)) {
                            System.out.println("Item ID  " + addItems.items[i].itemid);
                            System.out.println("Item Name:  " + addItems.items[i].name);
                            System.out.println("Item Price: " + addItems.items[i].price);
                            System.out.println("Quantity:  " + addItems.items[i].quantity);
                            System.out.println("Total cost: " + (addItems.items[i].price * addItems.items[i].quantity));
                        }
                    }
                }
                System.out.println("-----------------------------------");
            }
        }
        class Cart {
            Scanner scanner = new Scanner(System.in);
            Order order[] = new Order[50];
            int s = 0;
            public void process2() {
                while (true) {
                    System.out.println("1. Order");
                    System.out.println("2. Cancel Order");
                    System.out.println("3. Shows Orders");
                    System.out.println("4. Log out");
                    System.out.println("Enter your Choice");
                    int input = scanner.nextInt();
                    switch (input) {
                        case 1:
                            addOrder();
                            break;
                        case 2:
                            cancelOrder();
                            break;
                        case 3:
                            showOrder();
                            break;
                        case 4:
                            logout1();
                            break;
                    }
                }
            }
            void addOrder() {
                Order order1=new Order();
                System.out.println("-------------------------------------");
                for (int i = 0; i < addItems.nextItemIndex; i++) {
                    if (addItems.items[i] != null) {
                        addItems.items[i].print();
                    }
                }
                System.out.println("-------------------------------------");
                System.out.println("Enter the Item Name");
                String name = scanner.next();
                System.out.println("Enter the how many product");
                int quantity = scanner.nextInt();
                order1.orderid++;
                order1.item_name=name;
                order[s]=order1;
                s++;
                for (int i = 0; i < addItems.items.length; i++) {
                    if (addItems.items[i] != null&&order[i]!=null) {
                        if (addItems.items[i].name.equals(name)) {
                            addItems.items[i].quantity = quantity;
                            order[i].print();
                        }
                    }
                }
            }
            void cancelOrder() {
                boolean found=false;
                System.out.println("Enter the Order id");
                int orderid = scanner.nextInt();
                for (int i = 0; i < order.length; i++) {
                    if (order[i] != null) {
                        if (order[i].orderid == orderid) {
                            order[i] = null;
                            found=true;
                        }
                    }
                }
                if (!found)
                    System.out.println("No Orders");
            }
            void logout1() {
                System.out.println("Successfully Logout");
                home.process1();
            }
            void showOrder() {
                boolean found=false;
                for (int i = 0; i < order.length; i++) {
                    if (order[i] != null) {
                        order[i].print();
                        found=true;
                    }
                }
                if (!found)
                    System.out.println("No Orders");
            }
        }
    }
    public static void main(String arg[]) {
        Store store = new Store();
        store.home=store.new Home();
        store.home.process1();
    }
}