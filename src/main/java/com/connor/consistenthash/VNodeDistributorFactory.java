package com.connor.consistenthash;

 final public class VNodeDistributorFactory {

    public static VNodeDistributor getDistributor(final String distributorType){
        if(distributorType == null) return null;
        switch (distributorType){
            default: return new SimpleVNodeDistributor();
        }
    }
}
