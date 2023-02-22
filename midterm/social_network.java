
import java.util.Arrays;

public class social_network {
    // public dictionary that will hold the social network as profiles
    public LinkedDictionary<String, Profile> socialNetwork;

    // constructor
    public social_network() {
        socialNetwork = new LinkedDictionary<String, Profile>();
    }

    // join network
    public void joinNetwork(String name) {
        // create a new profile
        Profile profile = new Profile(name);
        // add the profile to the social network
        socialNetwork.add(name, profile);
    }

    // leave network
    public void leaveNetwork(String name) {
        // get the profile
        Profile leavingProfile = socialNetwork.getValue(name);
        // get the profile's friends
        Profile leavingProfilesFriends[] = new Profile[leavingProfile.getFriends().getLength()];
        for (int i = 0; i < leavingProfile.getFriends().getLength(); i++) {
            leavingProfilesFriends[i] = leavingProfile.getFriends().getEntry(i + 1);
        }
        // remove the profile from each of its friends
        for (int i = 0; i < leavingProfilesFriends.length; i++) {
            leavingProfilesFriends[i].removeFriend(leavingProfile);
        }
        // remove the profile from the social network
        socialNetwork.remove(name);
    }

    // search profile
    public Profile searchProfile(String name) {
        return socialNetwork.getValue(name);
    }

    public class Profile {
        // name of the profile
        private String name;
        // profile's status
        private String status;
        // profile's friends
        private AList<Profile> friends;

        // constructor
        public Profile(String name) {
            this.name = name;
            status = "No status";
            friends = new AList<Profile>();
        }
        // end constructor

        // get the name of the profile
        public String getName() {
            return name;
        }

        // get the status of the profile
        public String getStatus() {
            return status;
        }

        // set the status of the profile
        public void setStatus(String status) {
            this.status = status;
        }

        // add a friend to the profile
        public void addFriend(Profile friend) {
            friends.add(friend);
        }

        // remove a friend from the profile's friends array
        public void removeFriend(Profile friend) {

            // get the index of the friend
            int index = -1;
            for (int i = 0; i < friends.getLength(); i++) {
                if (friends.getEntry(i + 1).getName().equals(friend.getName())) {
                    index = i;
                    break;
                }
            }

            // remove the friend
            if (index != -1) {
                friends.remove(index + 1);
            }

        }

        // get the friends of the profile
        public AList<Profile> getFriends() {
            return friends;
        }

    } // end Profile class

    // test the social network, with names Fatih, Selma, Ismail, and Mehmet. Name the social network facebook.
    public static void main(String[] args) {
        social_network facebook = new social_network();
        facebook.joinNetwork("Fatih");
        facebook.joinNetwork("Selma");
        facebook.joinNetwork("Ismail");
        facebook.joinNetwork("Mehmet");
        facebook.searchProfile("Fatih").addFriend(facebook.searchProfile("Selma"));
        facebook.searchProfile("Fatih").addFriend(facebook.searchProfile("Ismail"));
        facebook.searchProfile("Fatih").addFriend(facebook.searchProfile("Mehmet"));
        facebook.searchProfile("Selma").addFriend(facebook.searchProfile("Fatih"));
        facebook.searchProfile("Selma").addFriend(facebook.searchProfile("Ismail"));
        facebook.searchProfile("Selma").addFriend(facebook.searchProfile("Mehmet"));
        facebook.searchProfile("Ismail").addFriend(facebook.searchProfile("Fatih"));
        facebook.searchProfile("Ismail").addFriend(facebook.searchProfile("Selma"));
        facebook.searchProfile("Ismail").addFriend(facebook.searchProfile("Mehmet"));
        facebook.searchProfile("Mehmet").addFriend(facebook.searchProfile("Fatih"));
        facebook.searchProfile("Mehmet").addFriend(facebook.searchProfile("Selma"));
        facebook.searchProfile("Mehmet").addFriend(facebook.searchProfile("Ismail"));
        facebook.leaveNetwork("Fatih");
        System.out.println(Arrays.toString(facebook.searchProfile("Selma").getFriends().toArray()));
        System.out.println(Arrays.toString(facebook.searchProfile("Ismail").getFriends().toArray()));
        System.out.println(Arrays.toString(facebook.searchProfile("Mehmet").getFriends().toArray()));
    }

} // end social_network class

