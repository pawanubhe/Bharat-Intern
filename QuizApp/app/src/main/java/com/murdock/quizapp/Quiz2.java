package com.murdock.quizapp;

public class Quiz2 {
    public static String questions[] = {
            "In Operating Systems, which of the following is/are CPU scheduling algorithms?",
            "In a timeshare operating system, when the time slot assigned to a process is completed, the process switches from the current state to?",
            "Swapping _______ be done when a process has pending I/O, or has to execute I/O operations only into operating system buffers.",
            "The operating system maintains a ______ table that keeps track of how many frames have been allocated, how many are there, and how many are available.",
            "The _________ presents a uniform device-access interface to the I/O subsystem, much as system calls provide a standard interface between the application and the operating system."
    };

    public static String options[][] = {
            {"Priority", "Round Robin", "Shortest Job First", "All of the mentioned"},
            {"Suspended state", "Terminated state", "Ready state", "Blocked state"},
            {"must never", "maybe", "can", "must"},
            {"memory", "mapping", "page", "frame"},
            {"Device drivers", "I/O systems", "Devices", "Buses"}
    };

    public static String answers[] = {
            "All of the mentioned", "Ready state", "must never", "frame", "Device drivers"
    };
}
