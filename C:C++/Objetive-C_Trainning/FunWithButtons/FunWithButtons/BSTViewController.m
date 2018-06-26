//
//  BSTViewController.m
//  FunWithButtons
//
//  Created by William Brown on 12/22/13.
//  Copyright (c) 2013 Brown Sound Technologies. All rights reserved.
//

#import "BSTViewController.h"

@interface BSTViewController ()

@end

@implementation BSTViewController

@synthesize nameField;

@synthesize numberField;

@synthesize sliderLabel;

@synthesize leftSwitch;

@synthesize rightSwitch;

@synthesize doSomethingButton;

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

- (IBAction)textFieldDoneEditing:(id)sender{
    
    [sender resignFirstResponder];
}

- (IBAction)backgroundTap:(id)sender{
    
    [nameField resignFirstResponder];
    [numberField resignFirstResponder];
}

- (IBAction)sliderChanged:(UISlider *)sender {
    
    int progressAsInt = (int)roundf(sender.value);
    sliderLabel.text = [NSString stringWithFormat: @"%d" , progressAsInt];
}

- (IBAction)switchChanged:(UISwitch *)sender {
    
    BOOL settings = sender.isOn;
    [leftSwitch setOn:settings animated:YES];
    [rightSwitch setOn:settings animated:YES];
}

- (IBAction)toggleControls:(UISegmentedControl *)sender {
    
    // 0 == swithches index. UISegmentedControl is an array
    // of buttons in a way.
    if ([sender selectedSegmentIndex] == 0)
    {
        leftSwitch.hidden = NO;
        rightSwitch.hidden = NO;
        doSomethingButton.hidden = YES;
    }
    else
    {
        leftSwitch.hidden = YES;
        rightSwitch.hidden = YES;
        doSomethingButton.hidden = NO;
    }
}

- (IBAction)buttonPressed:(id)sender {
    
    UIActionSheet * actionSheet = [[UIActionSheet alloc]
                                   initWithTitle:@"Are you sure?"
                                   delegate: self
                                   cancelButtonTitle: @"No way!"
                                   destructiveButtonTitle: @"Yes, I'm Sure!"
                                   otherButtonTitles: nil, nil];
    [actionSheet showInView:self.view];
}

- (void)actionSheet: (UIActionSheet *) actionSheet didDismissWithButtonIndex:(NSInteger)buttonIndex{
    
    if (buttonIndex != [actionSheet cancelButtonIndex]) {
        
        
        NSString *msg = nil;
        
        if (nameField.text.length > 0) {
            
            msg = [[NSString alloc] initWithFormat:
                   @"You can breathe easy, %@, everything went OK.", nameField.text];
        }
        else{
            
            msg = @"You can breathe easy, everything went OK";
        }
        
        UIAlertView *alert = [[UIAlertView alloc]
                              initWithTitle:@"Something was done"
                              message:msg
                              delegate:self
                              cancelButtonTitle:@"Phew!"
                              otherButtonTitles:nil, nil];
        
        [alert show];
    }
}
@end
