package Critiquing;

import java.util.Objects;

/**
 * This class will represent any operations we want to perform involving Timestamps
 * <p>
 * While it'll mainly be used as a "helper" class to create a Timestamp object, we will need it for various operations.
 */
public final class Timestamp {
    // define instance variables
    private final int minute;
    private final int seconds;
    private final double milliseconds;

    // Create a builder class
    public static class Builder {
        private int minute;
        private int seconds;
        private double milliseconds;

        public Builder() {

        }

        // set the minute
        public Builder setMinute(int val) {
            minute = val;
            return this;
        }

        // set the seconds
        public Builder setSeconds(int val) {
            seconds = val;
            return this;
        }

        // set the milliseconds
        public Builder setMilliseconds(double val) {
            milliseconds = val;
            return this;
        }

        // est the builder
        public Timestamp build() {
            return new Timestamp(this);
        }
    }

    // make constructor private
    private Timestamp(Builder builder) {
        this.minute = builder.minute;
        this.seconds = builder.seconds;
        this.milliseconds = builder.milliseconds;
    }

    /**
     * Gets the correct minute from the specified timestamp
     *
     * @return the minute from the timestamp
     */
    public int getMinute() {
        return this.minute;
    }

    /**
     * Gets the correct second from the specified timestamp
     *
     * @return the seconds from the timestamp
     */
    public int getSeconds() {
        return this.seconds;
    }

    /**
     * Gets the correct millisecond from the specified timestamp
     *
     * @return the milliseconds (if specified) from the timestamp
     */
    public double getMilliseconds() {
        return this.milliseconds;
    }


    // overriding equals in order to run tests properly
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Timestamp)) {
            return false;
        }

        Timestamp ts = (Timestamp) o;

        return ts.getMinute() == this.getMinute() && ts.getMilliseconds() == this.getMilliseconds() && ts.getSeconds() == this.getSeconds();
    }

    @Override
    public int hashCode() {
        return Objects.hash(seconds, minute, milliseconds);
    }

}
