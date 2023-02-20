
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
        ListInterface<Profile> leavingProfilesFriends = new AList<>();
        for (int i = 0; i < leavingProfile.getFriends().getCurrentSize(); i++) {
            leavingProfilesFriends.add(leavingProfile.getFriends().toArray()[i]);
        }
        // remove the profile from each of its friends
        for (int i = 0; i < leavingProfilesFriends.getLength(); i++) {
            leavingProfilesFriends.getEntry(i + 1).removeFriend(leavingProfile);
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
        private LinkedBag<Profile> friends;

        // constructor
        public Profile(String name) {
            this.name = name;
            status = "No status";
            friends = new LinkedBag<Profile>();
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

        // remove a friend from the profile
        public void removeFriend(Profile friend) {
            friends.remove(friend);
        }

        // get the friends of the profile
        public LinkedBag<Profile> getFriends() {
            return friends;
        }

    } // end Profile class

    // test the social network
    public static void main(String[] args) {
        // create a new social network
        social_network socialNetwork = new social_network();
        // join the network
        socialNetwork.joinNetwork("Fatih");
        socialNetwork.joinNetwork("Selma");
        // search for a profile
        Profile profile = socialNetwork.searchProfile("Fatih");
        // add a friend
        profile.addFriend(socialNetwork.searchProfile("Selma"));
        // set the status
        profile.setStatus("I'm feeling great!");
        // get the status
        System.out.println(profile.getStatus());
        // get the friends
        System.out.println(profile.getFriends());
        // leave the network
        socialNetwork.leaveNetwork("Fatih");
    }

} // end social_network class

