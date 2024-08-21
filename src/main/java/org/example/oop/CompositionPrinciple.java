package org.example.oop;

/*
    Compozitia = este procesul prin care o clasa principala este asamblata pe baza altor clase secundare
 */

class Laptop {

    private String modelName;
    private int modelNumber;
    private Double price;
    private CPU cpu;
    private RAM ram;
    private GPU gpu;
    // todo: Motherboard, etc

    public Laptop(String modelName, int modelNumber, Double price, CPU cpu, RAM ram, GPU gpu) {
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.price = price;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "modelName='" + modelName + '\'' +
                ", modelNumber=" + modelNumber +
                ", price=" + price +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", gpu=" + gpu +
                '}';
    }
}

class CPU {

    private String model;
    private int cores;
    private int threads;

    public CPU(String model, int cores, int threads) {
        this.model = model;
        this.cores = cores;
        this.threads = threads;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "model='" + model + '\'' +
                ", cores=" + cores +
                ", threads=" + threads +
                '}';
    }
}

class RAM {

    private String model;
    private int capacity;
    private String type;

    public RAM(int capacity, String type, String model) {
        this.capacity = capacity;
        this.type = type;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "model='" + model + '\'' +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }
}

class GPU {

    private String model;
    private int memorySize;
    private String memoryType;

    public GPU(int memorySize, String model, String memoryType) {
        this.memorySize = memorySize;
        this.model = model;
        this.memoryType = memoryType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    @Override
    public String toString() {
        return "GPU{" +
                "model='" + model + '\'' +
                ", memorySize=" + memorySize +
                ", memoryType='" + memoryType + '\'' +
                '}';
    }
}

public class CompositionPrinciple {

    public static void main(String[] args) {

        // Initializare babeasca
        CPU cpu1 = new CPU("Intel i7", 8, 16);
        RAM ram1 = new RAM(16, "DDR4", "Sirius");
        GPU gpu1 = new GPU(8, "Geforce 1090", "GDDR5");
        Laptop laptop1 = new Laptop(
                "MSI",
                20082024,
                9000.2,
                cpu1,
                ram1,
                gpu1
        );
        System.out.println(laptop1);

        // Initializare tinereasca
        Laptop laptop2 = new Laptop(
                "MSI",
                20082024,
                9000.2,
                new CPU("Intel i7", 8, 16),
                new RAM(16, "DDR4", "Sirius"),
                new GPU(8, "Geforce 1090", "GDDR5")
        );
        System.out.println(laptop2);
    }
}
