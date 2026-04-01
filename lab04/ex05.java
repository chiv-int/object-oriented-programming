package lab04;

import java.util.Scanner;

class Song {
    String title;
    String singer;
    String length;
    double price;

    Song(String title, String singer, String length, double price) {
        this.title = title;
        this.singer = singer;
        this.length = length;
        this.price = price;
    }
}

class Album {
    String title;
    String genre;
    Song[] songs = new Song[100];
    int songCount = 0;

    Album(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    void addSong(Song song) {
        songs[songCount++] = song;
    }
}

public class ex05 {
    static Album[] albums = new Album[100];
    static int albumCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== Menu ======");
            System.out.println("1.   View a music store");
            System.out.println("2.   Add a song");
            System.out.println("3.   Create an album");
            System.out.println("4.   Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewMusicStore();
                    break;
                case 2:
                    addSong(scanner);
                    break;
                case 3:
                    createAlbum(scanner);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
            System.out.println();
        } while (choice != 4);

        scanner.close();
    }

    static void viewMusicStore() {
        if (albumCount == 0) {
            System.out.println("No albums found.");
            return;
        }
        System.out.println("====== Music Store ======");
        for (int i = 0; i < albumCount; i++) {
            Album album = albums[i];
            System.out.println("\nAlbum: " + album.title);
            if (album.songCount == 0) {
                System.out.println("None of song");
            } else {
                for (int j = 0; j < album.songCount; j++) {
                    Song s = album.songs[j];
                    System.out.printf("| %-2d| %-18s| %-10s| %-8s| %-5.0f$     |%n",
                            j + 1, s.title, s.singer, s.length, s.price);
                }
            }
        }
    }

    static void createAlbum(Scanner scanner) {
        System.out.println("===== Create new album ====");
        System.out.print("Album title: ");
        String title = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        albums[albumCount++] = new Album(title, genre);
        System.out.println("Album created successfully.");
    }

    static void addSong(Scanner scanner) {
        if (albumCount == 0) {
            System.out.println("No albums available. Please create an album first.");
            return;
        }

        System.out.println("===== Add a new song ====");
        System.out.println("Select following album:");
        for (int i = 0; i < albumCount; i++) {
            System.out.println((i + 1) + ".  " + albums[i].title);
        }
        System.out.print("Choose an opt: ");
        int albumChoice = scanner.nextInt();
        scanner.nextLine();

        if (albumChoice < 1 || albumChoice > albumCount) {
            System.out.println("Invalid album choice.");
            return;
        }

        Album selectedAlbum = albums[albumChoice - 1];

        System.out.print("Song title: ");
        String title = scanner.nextLine();
        System.out.print("Signer: ");
        String singer = scanner.nextLine();
        System.out.print("Length: ");
        String length = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        selectedAlbum.addSong(new Song(title, singer, length, price));
        System.out.println("\nA new song added to the album");
    }
}