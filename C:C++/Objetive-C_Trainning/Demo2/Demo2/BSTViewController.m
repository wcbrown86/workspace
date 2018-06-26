//
//  BSTViewController.m
//  Demo2
//
//  Created by William Brown on 12/19/13.
//  Copyright (c) 2013 Brown Sound Technologies. All rights reserved.
//

#import "BSTViewController.h"

@interface BSTViewController ()

@end

@implementation BSTViewController

@synthesize textField;
@synthesize textLabel;


- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)changeLable:(id)sender
{
    NSString *string = [[NSString alloc] initWithFormat:@"Hello %@" , [textField text]];
    [textLabel setText:string];
}
@end
